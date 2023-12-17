package ma.zs.easystock.service.impl.admin.reglement;


import ma.zs.easystock.bean.core.reglement.ReglementAvoirAchat;
import ma.zs.easystock.dao.criteria.core.reglement.ReglementAvoirAchatCriteria;
import ma.zs.easystock.dao.facade.core.reglement.ReglementAvoirAchatDao;
import ma.zs.easystock.dao.specification.core.reglement.ReglementAvoirAchatSpecification;
import ma.zs.easystock.service.facade.admin.reglement.ReglementAvoirAchatAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.reglement.ReglementAvoirAchatDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.service.facade.admin.stock.AchatAdminService ;
import ma.zs.easystock.bean.core.stock.Achat ;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.ModeReglementAdminService ;
import ma.zs.easystock.bean.core.gestionchequeffet.ModeReglement ;
import ma.zs.easystock.service.facade.admin.stock.AvoirAchatAdminService ;
import ma.zs.easystock.bean.core.stock.AvoirAchat ;

import java.util.List;
@Service
public class ReglementAvoirAchatAdminServiceImpl extends AbstractServiceImpl<ReglementAvoirAchat, ReglementAvoirAchatCriteria, ReglementAvoirAchatDao> implements ReglementAvoirAchatAdminService {
    public static final String TEMPLATE = "template/reglementAvoirAchat.vm";
    public static final String FILE_NAME = "reglementAvoirAchat.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("reference"));


    ATTRIBUTES.add(new Attribute("montant","BigDecimal"));



    ATTRIBUTES.add(new Attribute("description"));

    }

    @Override
    public HttpEntity<byte[]> createPdf(ReglementAvoirAchatDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public ReglementAvoirAchat findByReferenceEntity(ReglementAvoirAchat t){
        return  dao.findByReference(t.getReference());
    }

    public List<ReglementAvoirAchat> findByAchatId(Long id){
        return dao.findByAchatId(id);
    }
    public int deleteByAchatId(Long id){
        return dao.deleteByAchatId(id);
    }
    public long countByAchatId(Long id){
        return dao.countByAchatId(id);
    }
    public List<ReglementAvoirAchat> findByModeReglementId(Long id){
        return dao.findByModeReglementId(id);
    }
    public int deleteByModeReglementId(Long id){
        return dao.deleteByModeReglementId(id);
    }
    public long countByModeReglementId(Long id){
        return dao.countByModeReglementId(id);
    }
    public List<ReglementAvoirAchat> findByAvoirAchatId(Long id){
        return dao.findByAvoirAchatId(id);
    }
    public int deleteByAvoirAchatId(Long id){
        return dao.deleteByAvoirAchatId(id);
    }
    public long countByAvoirAchatNumeroFactureAvoirFournisseur(String numeroFactureAvoirFournisseur){
        return dao.countByAvoirAchatNumeroFactureAvoirFournisseur(numeroFactureAvoirFournisseur);
    }

    public List<ReglementAvoirAchat> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(ReglementAvoirAchat.class, ReglementAvoirAchatSpecification.class);
    }


    @Autowired
    private AchatAdminService achatService ;
    @Autowired
    private ModeReglementAdminService modeReglementService ;
    @Autowired
    private AvoirAchatAdminService avoirAchatService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public ReglementAvoirAchatAdminServiceImpl(ReglementAvoirAchatDao dao) {
        super(dao);
    }

}
