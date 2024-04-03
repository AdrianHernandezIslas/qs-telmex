package com.telmex.demo.controller;

import com.telmex.demo.dto.CustomUserDetails;
import com.telmex.demo.entity.BaseObject;
import com.telmex.demo.entity.UserSession;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class BaseController {

    protected UserSession getSession(Principal principal){
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) principal;
        CustomUserDetails userDetails = (CustomUserDetails)token.getPrincipal();
        return userDetails.getSession();
    }

    protected void addSession(BaseObject baseObject,Principal principal){
        UserSession session = getSession(principal);
        baseObject.setSession(session);

    }

    protected Sort buildSort(Optional<String[]> columnsNameOptional) {
        List<Sort.Order> orders = new ArrayList<>();
        if (columnsNameOptional.isPresent() ) {
            String[] columnsName = columnsNameOptional.get();
            if (columnsName[0].contains(",")){
                for (String columnName : columnsName) {
                    String[] _sort = columnName.split(",");
                    orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
                }
            }else {
                orders.add(new Sort.Order(getSortDirection(columnsName[1]),columnsName[0]));
            }

        }
        return Sort.by(orders);
    }

    protected Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }
}
