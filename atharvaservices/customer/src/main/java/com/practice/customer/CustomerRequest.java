package com.practice.customer;

public record CustomerRequest(
        String firstname,
        String lastname,
        String email) {
}
