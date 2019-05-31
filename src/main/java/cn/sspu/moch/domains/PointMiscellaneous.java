package cn.sspu.moch.domains;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PointMiscellaneous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String key;
    private String value;

    @ManyToOne
    private Point point;
}
