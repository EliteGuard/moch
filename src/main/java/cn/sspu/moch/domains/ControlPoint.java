package cn.sspu.moch.domains;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class ControlPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal x;
    private BigDecimal y;

    @ManyToOne
    private Path path;

}
