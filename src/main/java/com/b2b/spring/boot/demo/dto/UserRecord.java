package com.b2b.spring.boot.demo.dto;

public record UserRecord(Long id, String nome, String email, IndirizzoRecord dettaglio) {
}
