package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.util.ListUtil;

import ma.zs.easystock.ws.converter.stock.AvoirAchatItemConverter;
import ma.zs.easystock.ws.converter.commun.EtatAchatConverter;
import ma.zs.easystock.ws.converter.commun.DepotConverter;
import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.commun.EntrepriseSocieteConverter;
import ma.zs.easystock.ws.converter.stock.AchatItemConverter;
import ma.zs.easystock.ws.converter.stock.TaxeConverter;
import ma.zs.easystock.ws.converter.commun.FournisseurConverter;
import ma.zs.easystock.ws.converter.commun.EtatAvoirAchatConverter;
import ma.zs.easystock.ws.converter.stock.AvoirAchatConverter;



import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.stock.Achat;
import ma.zs.easystock.ws.dto.stock.AchatDto;

@Component
public class AchatConverter extends AbstractConverter<Achat, AchatDto> {

    @Autowired
    private AvoirAchatItemConverter avoirAchatItemConverter ;
    @Autowired
    private EtatAchatConverter etatAchatConverter ;
    @Autowired
    private DepotConverter depotConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private EntrepriseSocieteConverter entrepriseSocieteConverter ;
    @Autowired
    private AchatItemConverter achatItemConverter ;
    @Autowired
    private TaxeConverter taxeConverter ;
    @Autowired
    private FournisseurConverter fournisseurConverter ;
    @Autowired
    private EtatAvoirAchatConverter etatAvoirAchatConverter ;
    @Autowired
    private AvoirAchatConverter avoirAchatConverter ;
    private boolean entrepriseSociete;
    private boolean fournisseur;
    private boolean etatAchat;
    private boolean achatItems;
    private boolean avoirs;

    public  AchatConverter(AvoirAchatItem avoirAchatItemEtatAchat etatAchatDepot depotProduit produitEntrepriseSociete entrepriseSocieteAchatItem achatItemTaxe taxeFournisseur fournisseurEtatAvoirAchat etatAvoirAchatAvoirAchat avoirAchat){
        super(Achat.class, AchatDto.class);
        init(true);
        this.avoirAchatItem =  avoirAchatItem
        this.etatAchat =  etatAchat
        this.depot =  depot
        this.produit =  produit
        this.entrepriseSociete =  entrepriseSociete
        this.achatItem =  achatItem
        this.taxe =  taxe
        this.fournisseur =  fournisseur
        this.etatAvoirAchat =  etatAvoirAchat
        this.avoirAchat =  avoirAchat
    }

    @Override
    public Achat toItem(AchatDto dto) {
        if (dto == null) {
            return null;
        } else {
        Achat item = new Achat();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateFacture()))
                item.setDateFacture(DateUtil.stringEnToDate(dto.getDateFacture()));
            if(StringUtil.isNotEmpty(dto.getReferenceFacture()))
                item.setReferenceFacture(dto.getReferenceFacture());
            if(StringUtil.isNotEmpty(dto.getMontantHt()))
                item.setMontantHt(dto.getMontantHt());
            if(StringUtil.isNotEmpty(dto.getMontantTva()))
                item.setMontantTva(dto.getMontantTva());
            if(StringUtil.isNotEmpty(dto.getMontantTtc()))
                item.setMontantTtc(dto.getMontantTtc());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.entrepriseSociete && dto.getEntrepriseSociete()!=null &&  dto.getEntrepriseSociete().getId() != null)
                item.setEntrepriseSociete(entrepriseSocieteConverter.toItem(dto.getEntrepriseSociete())) ;

            if(this.fournisseur && dto.getFournisseur()!=null &&  dto.getFournisseur().getId() != null)
                item.setFournisseur(fournisseurConverter.toItem(dto.getFournisseur())) ;

            if(this.etatAchat && dto.getEtatAchat()!=null &&  dto.getEtatAchat().getId() != null)
                item.setEtatAchat(etatAchatConverter.toItem(dto.getEtatAchat())) ;


            if(this.achatItems && ListUtil.isNotEmpty(dto.getAchatItems()))
                item.setAchatItems(achatItemConverter.toItem(dto.getAchatItems()));
            if(this.avoirs && ListUtil.isNotEmpty(dto.getAvoirs()))
                item.setAvoirs(avoirAchatConverter.toItem(dto.getAvoirs()));


        return item;
        }
    }

    @Override
    public AchatDto toDto(Achat item) {
        if (item == null) {
            return null;
        } else {
            AchatDto dto = new AchatDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateFacture()!=null)
                dto.setDateFacture(DateUtil.dateTimeToString(item.getDateFacture()));
            if(StringUtil.isNotEmpty(item.getReferenceFacture()))
                dto.setReferenceFacture(item.getReferenceFacture());
            if(StringUtil.isNotEmpty(item.getMontantHt()))
                dto.setMontantHt(item.getMontantHt());
            if(StringUtil.isNotEmpty(item.getMontantTva()))
                dto.setMontantTva(item.getMontantTva());
            if(StringUtil.isNotEmpty(item.getMontantTtc()))
                dto.setMontantTtc(item.getMontantTtc());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.entrepriseSociete && item.getEntrepriseSociete()!=null) {
            dto.setEntrepriseSociete(entrepriseSocieteConverter.toDto(item.getEntrepriseSociete())) ;
        }
        if(this.fournisseur && item.getFournisseur()!=null) {
            dto.setFournisseur(fournisseurConverter.toDto(item.getFournisseur())) ;
        }
        if(this.etatAchat && item.getEtatAchat()!=null) {
            dto.setEtatAchat(etatAchatConverter.toDto(item.getEtatAchat())) ;
        }
        if(this.achatItems && ListUtil.isNotEmpty(item.getAchatItems())){
            achatItemConverter.init(true);
            achatItemConverter.setAchat(false);
            dto.setAchatItems(achatItemConverter.toDto(item.getAchatItems()));
            achatItemConverter.setAchat(true);

        }
        if(this.avoirs && ListUtil.isNotEmpty(item.getAvoirs())){
            avoirAchatConverter.init(true);
            avoirAchatConverter.setAchat(false);
            dto.setAvoirs(avoirAchatConverter.toDto(item.getAvoirs()));
            avoirAchatConverter.setAchat(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.achatItems = value;
        this.avoirs = value;
    }

    public void initObject(boolean value) {
        this.entrepriseSociete = value;
        this.fournisseur = value;
        this.etatAchat = value;
    }


    public AvoirAchatItemConverter getAvoirAchatItemConverter(){
        return this.avoirAchatItemConverter;
    }
    public void setAvoirAchatItemConverter(AvoirAchatItemConverter avoirAchatItemConverter ){
        this.avoirAchatItemConverter = avoirAchatItemConverter;
    }
    public EtatAchatConverter getEtatAchatConverter(){
        return this.etatAchatConverter;
    }
    public void setEtatAchatConverter(EtatAchatConverter etatAchatConverter ){
        this.etatAchatConverter = etatAchatConverter;
    }
    public DepotConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotConverter(DepotConverter depotConverter ){
        this.depotConverter = depotConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public EntrepriseSocieteConverter getEntrepriseSocieteConverter(){
        return this.entrepriseSocieteConverter;
    }
    public void setEntrepriseSocieteConverter(EntrepriseSocieteConverter entrepriseSocieteConverter ){
        this.entrepriseSocieteConverter = entrepriseSocieteConverter;
    }
    public AchatItemConverter getAchatItemConverter(){
        return this.achatItemConverter;
    }
    public void setAchatItemConverter(AchatItemConverter achatItemConverter ){
        this.achatItemConverter = achatItemConverter;
    }
    public TaxeConverter getTaxeConverter(){
        return this.taxeConverter;
    }
    public void setTaxeConverter(TaxeConverter taxeConverter ){
        this.taxeConverter = taxeConverter;
    }
    public FournisseurConverter getFournisseurConverter(){
        return this.fournisseurConverter;
    }
    public void setFournisseurConverter(FournisseurConverter fournisseurConverter ){
        this.fournisseurConverter = fournisseurConverter;
    }
    public EtatAvoirAchatConverter getEtatAvoirAchatConverter(){
        return this.etatAvoirAchatConverter;
    }
    public void setEtatAvoirAchatConverter(EtatAvoirAchatConverter etatAvoirAchatConverter ){
        this.etatAvoirAchatConverter = etatAvoirAchatConverter;
    }
    public AvoirAchatConverter getAvoirAchatConverter(){
        return this.avoirAchatConverter;
    }
    public void setAvoirAchatConverter(AvoirAchatConverter avoirAchatConverter ){
        this.avoirAchatConverter = avoirAchatConverter;
    }
    public boolean  isEntrepriseSociete(){
        return this.entrepriseSociete;
    }
    public void  setEntrepriseSociete(boolean entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public boolean  isFournisseur(){
        return this.fournisseur;
    }
    public void  setFournisseur(boolean fournisseur){
        this.fournisseur = fournisseur;
    }
    public boolean  isEtatAchat(){
        return this.etatAchat;
    }
    public void  setEtatAchat(boolean etatAchat){
        this.etatAchat = etatAchat;
    }
    public boolean  isAchatItems(){
        return this.achatItems ;
    }
    public void  setAchatItems(boolean achatItems ){
        this.achatItems  = achatItems ;
    }
    public boolean  isAvoirs(){
        return this.avoirs ;
    }
    public void  setAvoirs(boolean avoirs ){
        this.avoirs  = avoirs ;
    }
}
