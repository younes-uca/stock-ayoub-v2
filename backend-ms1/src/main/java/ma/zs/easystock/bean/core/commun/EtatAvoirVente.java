package ma.zs.easystock.bean.core.commun;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "etat_avoir_vente")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="etat_avoir_vente_seq",sequenceName="etat_avoir_vente_seq",allocationSize=1, initialValue = 1)
public class EtatAvoirVente   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;



    public EtatAvoirVente(){
        super();
    }

    public EtatAvoirVente(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public EtatAvoirVente(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="etat_avoir_vente_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtatAvoirVente etatAvoirVente = (EtatAvoirVente) o;
        return id != null && id.equals(etatAvoirVente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

