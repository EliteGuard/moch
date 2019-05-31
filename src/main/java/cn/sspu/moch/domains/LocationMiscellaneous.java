package cn.sspu.moch.domains;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class LocationMiscellaneous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String key;
    private String value;

    @ManyToOne
    private Location location;

}
