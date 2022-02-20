package com.techprovint.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class ApiController {

    @RequestMapping(value = "/anonymous", method = RequestMethod.GET)
    public ResponseEntity<String> getAnonymous() {
        return ResponseEntity.ok("Hello Anonymous");
    }

    @CrossOrigin(origins = {"http://localhost:3000"}, allowedHeaders = "*")
    @RolesAllowed("user")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    //public ResponseEntity<String> getUser(@RequestHeader String authorization) {
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("Hello User");
    }

    @CrossOrigin(origins = {"http://localhost:3000"}, allowedHeaders = "*")
    @RolesAllowed("admin")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    //public ResponseEntity<String> getAdmin(@RequestHeader String authorization) {
    public ResponseEntity<String> getAdmin() {
        return ResponseEntity.ok("Hello Admin");
    }

    @CrossOrigin(origins = {"http://localhost:3000"}, allowedHeaders = "*")
    @RolesAllowed({ "admin", "user" })
    @RequestMapping(value = "/all-user", method = RequestMethod.GET)
    //public ResponseEntity<String> getAllUser(@RequestHeader String authorization) {
    public ResponseEntity<String> getAllUser() {
        return ResponseEntity.ok("Hello All User");
    }
}