package org.example.afterThrowing.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public void addMember(){
        System.out.println(getClass()+" : Adding member...!");
    }

    public int getJumps(){
        System.out.println(getClass()+" : doing jumps");
        return 10;
    }
}
