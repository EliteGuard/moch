package cn.sspu.moch.domains;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BlockMiscellaneous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String key;
    private String value;

    @ManyToOne
    private Block block;
}
