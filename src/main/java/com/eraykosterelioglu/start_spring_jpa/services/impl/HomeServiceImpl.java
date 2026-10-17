package com.eraykosterelioglu.start_spring_jpa.services.impl;

import com.eraykosterelioglu.start_spring_jpa.dto.DtoHome;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoRoom;
import com.eraykosterelioglu.start_spring_jpa.entites.Home;
import com.eraykosterelioglu.start_spring_jpa.entites.Room;
import com.eraykosterelioglu.start_spring_jpa.repository.HomeRepository;
import com.eraykosterelioglu.start_spring_jpa.services.IHomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private HomeRepository homeRepository;

    public DtoHome findHomeById(Long id) {
        Optional<Home> optional = homeRepository.findById(id);

        if(optional.isEmpty()) {
            return null;
        }
        Home dbHome = optional.get();
        DtoHome dtoHome = new DtoHome();
        BeanUtils.copyProperties(dbHome,dtoHome);

        List<Room> dbRooms = optional.get().getRoom();

        if(dbRooms != null && !dbRooms.isEmpty()) {
            for(Room room : dbRooms) {
                DtoRoom dtoRoom = new DtoRoom();
                BeanUtils.copyProperties(room,dtoRoom);
                dtoHome.getRoom().add(dtoRoom);
            }
        }

        return dtoHome;
    }
}
