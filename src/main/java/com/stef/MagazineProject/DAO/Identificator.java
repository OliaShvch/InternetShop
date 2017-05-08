package com.stef.MagazineProject.DAO;

import java.io.Serializable;

public interface Identificator<PK extends Serializable> {
    int getId();
}