/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.model;

/**
 *
 * @author kevin
 */
public class Player {
    private int code;
    private Team team;
    private String name;
    private int age;
    private double height;
    private double weight;

    /**
     *
     */
    public Player() {
    }

    public Player(int code, Team team, String name, int age, double height, double weight) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.team = team;
    }

    

    /**
     * 
     * @return El nombre del jugador.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name El nombre del jugador.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return La edad del jugador. (int)
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @param age La edad del jugador. (int)
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     *
     * @return La estatura del jugador. (double)
     */
    public double getHeight() {
        return height;
    }

    /**
     *
     * @param height La estatura del jugador. (double)
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     *
     * @return El peso del jugador. (double)
     */
    public double getWeight() {
        return weight;
    }

    /**
     *
     * @param weight El peso del jugador. (double)
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    
    @Override
    public String toString() {
        return name;
}
}
