package org.example.Dto;

import org.example.Entity.BorrowBook;
import org.example.Entity.Member;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public class BorrowBookDto {

        private int id;

        private int qty;

        private Date dueDate;

        private String status;

        private Timestamp addedDate;

        private Member member;

    }
