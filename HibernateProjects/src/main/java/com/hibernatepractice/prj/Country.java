package com.hibernatepractice.prj;

import javax.persistence.*;

@Entity
@Table(name = "countries")

public class Country {
    @Id
    @Column(name = "country_id", length = 2)
    private String id;

    @Column(name = "country_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    private Region reg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getReg() {
        return reg;
    }

    public void setReg(Region reg) {
        this.reg = reg;
    }
}

/*
 * @Entity:
 * Marks this class as a JPA entity that will be mapped to a table in the database.
 * 
 * @Table(name = "countries"):
 * Specifies the table name in the database that this entity corresponds to, in this case, the countries table.
 * 
 * @Id:
 * Identifies the primary key field for this entity. Here, the id field uniquely identifies each Country.
 * 
 * @Column(name = "country_id", length = 2):
 * Maps the id field to the country_id column in the database and sets a constraint on the column length (2 characters, usually for country codes like "US", "IN").
 * 
 * @Column(name = "country_name"):
 * Maps the name field to the country_name column in the database. It holds the country’s name.
 * 
 * @ManyToOne: 
 * Indicates a Many-to-One relationship between Country and Region, meaning that each country belongs to one region, but a region can have multiple countries.
 * 
 * @JoinColumn(name = "region_id", nullable = false):
 * Specifies that the region_id column in the countries table acts as a foreign key linking to the Region entity.
 * 
 * The nullable = false part ensures that every country must be associated with a region (i.e., a country cannot exist without a region).
 * 
 * Getters and Setters:
 * These methods are necessary for accessing and modifying the id, name, and region fields.
 */
