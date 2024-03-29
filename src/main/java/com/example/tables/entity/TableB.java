package com.example.tables.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tableB", indexes = @Index(columnList = "created_at"))
public class TableB {

    @Id
    private UUID id;

    private Timestamp createdAt;

}
