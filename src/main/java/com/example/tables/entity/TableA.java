package com.example.tables.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tableA")
@AllArgsConstructor
@NoArgsConstructor
public class TableA {

    @Id
    private UUID id;
    private Timestamp createdAt;

}
