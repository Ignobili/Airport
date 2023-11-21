package com.example.demo.service.flylog;

import com.example.demo.model.Flylog;
import com.example.demo.repository.FlylogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlylogServiceImpl implements FlylogService{

    @Autowired
    private FlylogRepository flylogRepository;
    @Override
    public void createNewFlylog(Flylog flylog) {

        flylogRepository.save(flylog);
    }
}
