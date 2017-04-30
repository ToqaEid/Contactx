/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jets.contactx.entitiy;

/**
 *
 * @author Eslam
 */
public class GroupContactsCount {
    private Group1 group;
    private int count;

    public GroupContactsCount(Group1 group, int count) {
        this.group = group;
        this.count = count;
    }

    public GroupContactsCount() {
    }

    public Group1 getGroup() {
        return group;
    }

    public void setGroup(Group1 group) {
        this.group = group;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "GroupContactsCount{" + "group=" + group + ", count=" + count + '}';
    }
}
