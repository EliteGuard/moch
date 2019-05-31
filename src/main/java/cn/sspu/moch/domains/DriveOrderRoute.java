package cn.sspu.moch.domains;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DriveOrderRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Path path;

    @ManyToOne
    private Point destination;

    @ManyToOne
    private DriveOrder dorder;

}
