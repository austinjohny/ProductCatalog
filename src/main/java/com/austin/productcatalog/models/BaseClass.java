package com.austin.productcatalog.models;

import java.util.Date;

public abstract class BaseClass {
    private long id;
    private Date createdAt;
    private Date modifiedAt;

    // Maintaining state to do "soft delete", i.e. instead of deleting the record from the database, we will just mark it as inactive
    private State state;
}
