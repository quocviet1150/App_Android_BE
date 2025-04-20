package com.example.datn.service.Impl;

import com.example.datn.dto.EmployeeCreateCameraDto;
import com.example.datn.dto.EmployeeCreateCardDto;
import com.example.datn.dto.EmployeeDto;
import com.example.datn.entity.EmployeeManagement;
import com.example.datn.entity.TimeManagement;
import com.example.datn.repository.EmployeeManagementRepository;
import com.example.datn.repository.TimeManagementRepository;
import com.example.datn.service.EmployeeManagementService;
import io.jsonwebtoken.lang.Collections;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.List;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

    @Autowired
    private EmployeeManagementRepository employeeManagementRepository;

    @Autowired
    private TimeManagementRepository timeManagementRepository;

    /**
     * @{inheritDoc}
     */
    @Override
    public List<EmployeeManagement> getAllEmployeeByDepartmentId(Long departmentId) throws Exception {
        List<EmployeeManagement> employeeManagements;
        try {
            // Check if departmentId is null or empty
            if (departmentId == null) {
                throw new Exception();
            }
            employeeManagements = employeeManagementRepository.findByDepartmentId(departmentId);
            // Check if employeeManagements is null or empty
            if (Collections.isEmpty(employeeManagements)) {
                throw new Exception();
            }

            // return employeeManagements;
            return employeeManagements;
        } catch (Exception e) {
            e.fillInStackTrace();
            throw e;
        }
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public void changeStatus(Long employeeId, Integer status) throws Exception {
        try {
            // Check if employeeId is null or empty
            if (employeeId == null) {
                throw new Exception();
            }

            // Fetch employee management by employeeId
            EmployeeManagement employeeManagement = employeeManagementRepository.findById(employeeId).orElse(null);
            if (employeeManagement == null) {
                throw new Exception();
            }
            // Change status of employee
            employeeManagement.setStatus(status);
            employeeManagementRepository.save(employeeManagement);
        } catch (Exception e) {
            e.fillInStackTrace();
            throw e;
        }
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public void deleteEmployee(Long employeeId) {
        try {
            // Check if employeeId is null or empty
            if (employeeId == null) {
                throw new Exception();
            }

            // TODO: Implement the logic to delete the employee
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public EmployeeDto getEmployeeByEmployeeCode(String employeeCode) throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        try {
            if (StringUtils.isEmpty(employeeCode)) {
                throw new Exception();
            }

            // Fetch time managements by employeeId
            List<TimeManagement> timeManagements = timeManagementRepository.findTimeManagementsByEmployeeCode(employeeCode);
            if (!Collections.isEmpty(timeManagements)) {
                employeeDto.setTimeManagements(timeManagements);
            }

            // Fetch employee management by employeeId
            EmployeeManagement employeeManagement = employeeManagementRepository.findByEmployeeCode(employeeCode);
            if (employeeManagement == null) {
                throw new Exception();
            }

            // Map EmployeeManagement to EmployeeDto
            employeeDto.setId(employeeManagement.getId());
            employeeDto.setEmployeeCode(employeeManagement.getEmployeeCode());
            employeeDto.setDepartmentId(employeeManagement.getDepartmentId());
            employeeDto.setFullName(employeeManagement.getFullName());
            employeeDto.setLevel(employeeManagement.getLevel());
            employeeDto.setNumberOfWorkingDays(employeeManagement.getNumberOfWorkingDays());
            employeeDto.setNumberOfOffDays(employeeManagement.getNumberOfOffDays());
            employeeDto.setSalary(employeeManagement.getSalary());
            employeeDto.setDirectoryPath(employeeManagement.getDirectoryPath());
            employeeDto.setStatus(employeeManagement.getStatus());

            // return employeeDto
            return employeeDto;
        } catch (Exception e) {
            e.fillInStackTrace();
            throw e;
        }
    }

    @Override
    public EmployeeManagement createEmployeeUseCard(EmployeeCreateCardDto employeeCreateCardDto) {
        EmployeeManagement employeeManagement = new EmployeeManagement();
        try {
            employeeManagement.setEmployeeCode(employeeCreateCardDto.getEmployeeCode());
            employeeManagement.setDepartmentId(employeeCreateCardDto.getDepartmentId());
            employeeManagement.setFullName(employeeCreateCardDto.getFullName());
            employeeManagement.setLevel(employeeCreateCardDto.getLevel());
            employeeManagement.setNumberOfWorkingDays(0L);
            employeeManagement.setNumberOfOffDays(0L);
            employeeManagement.setSalary(employeeCreateCardDto.getSalary());
            employeeManagement.setStatus(employeeCreateCardDto.getStatus());
            return employeeManagementRepository.save(employeeManagement);
        } catch (Exception e) {
            e.fillInStackTrace();
            throw e;
        }
    }

    @Override
    public EmployeeManagement createEmployeeUseCamera(EmployeeCreateCameraDto employeeCreateCameraDto) throws Exception {
        EmployeeManagement employeeManagement = new EmployeeManagement();
        try {
            employeeManagement.setEmployeeCode(employeeCreateCameraDto.getEmployeeCode());
            employeeManagement.setDepartmentId(employeeCreateCameraDto.getDepartmentId());
            employeeManagement.setFullName(employeeCreateCameraDto.getFullName());
            employeeManagement.setLevel(employeeCreateCameraDto.getLevel());
            employeeManagement.setNumberOfWorkingDays(0L);
            employeeManagement.setNumberOfOffDays(0L);
            employeeManagement.setSalary(employeeCreateCameraDto.getSalary());
            employeeManagement.setStatus(employeeCreateCameraDto.getStatus());
            String filePath = saveBase64Image(employeeCreateCameraDto.getBase64Image(), employeeCreateCameraDto.getEmployeeCode());
            employeeManagement.setDirectoryPath(filePath);
            return employeeManagementRepository.save(employeeManagement);
        } catch (Exception e) {
            e.fillInStackTrace();
            throw e;
        }
    }

    private String saveBase64Image(String base64Image, String employeeCode) throws Exception {
        String[] parts = base64Image.split(",");
        String imageData = parts.length > 1 ? parts[1] : parts[0];
        byte[] decodedBytes = Base64.getDecoder().decode(imageData);
        String directoryPath = "C:/employee_images/";
        File dir = new File(directoryPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String fileName = "employee_" + employeeCode + ".png";
        String filePath = directoryPath + File.separator + fileName;

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(decodedBytes);
        }

        return filePath;
    }

}
