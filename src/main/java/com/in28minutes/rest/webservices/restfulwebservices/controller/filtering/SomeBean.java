package com.in28minutes.rest.webservices.restfulwebservices.controller.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Static filtering
 * */
@Data
@NoArgsConstructor
@Getter
@AllArgsConstructor
//@JsonIgnoreProperties({"field1", "field2"})

// @JsonFilter for dynamic filter
@JsonFilter("SomeBeanFilter")
public class SomeBean {
    private String field1;

//  @JsonIgnore
    private String field2;
    private String field3;
}
