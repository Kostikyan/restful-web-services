package com.in28minutes.rest.webservices.restfulwebservices.entity.versioning;

import com.in28minutes.rest.webservices.restfulwebservices.entity.versioning.auxiliary_objects.Name;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonV2 {
    private Name name;
}
