package com.catering.service.impl;

import com.catering.mapper.TagMapperLxz;
import com.catering.service.TagServiceLxz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TagServiceIMplLxz implements TagServiceLxz {
    @Autowired
    private TagMapperLxz tagMapperLxz;
    @Override
    public List<String> findCuisine() {
        return tagMapperLxz.findCuisine();
    }
}
