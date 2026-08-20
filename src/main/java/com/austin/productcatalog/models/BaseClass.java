package com.austin.productcatalog.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseClass {
    @Id
    private long id;
    private Date createdAt;
    private Date modifiedAt;

    // Maintaining state to do "soft delete",
    // i.e. instead of deleting the record from the database, we will just mark it as inactive
    private State state;
}
