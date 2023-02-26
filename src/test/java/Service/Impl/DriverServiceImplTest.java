package Service.Impl;

import Service.DriverService;
import config.WebRootConfig;
import dto.DriverDTO;
import entity.Driver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import repo.AdminRepo;
import repo.DriverRepo;

import static org.junit.jupiter.api.Assertions.*;
@WebAppConfiguration
@ContextConfiguration(classes = {WebRootConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
class DriverServiceImplTest {
    @Autowired
    DriverRepo repo;
    @Autowired
    DriverService service;

    @Test
    void saveDriver() {
       DriverDTO dto1=new DriverDTO("123","123",123456,"123",true);
          service.saveDriver(dto1);


    }
}