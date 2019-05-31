package cn.sspu.moch.domains;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class LocationTypeAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private LocationType type;

}
