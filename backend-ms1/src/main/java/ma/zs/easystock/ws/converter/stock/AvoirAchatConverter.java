package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.util.ListUtil;

import ma.zs.easystock.ws.converter.stock.AvoirAchatItemConverter;
import ma.zs.easystock.ws.converter.stock.TaxeConverter;
import ma.zs.easystock.ws.converter.commun.FournisseurConverter;
import ma.zs.easystock.ws.converter.commun.DepotConverter;
import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.commun.EtatAvoirAchatConverter;
import ma.zs.easystock.ws.converter.commun.EntrepriseSocieteConverter;



import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.stock.AvoirAchat;
import ma.zs.easystock.ws.dto.stock.AvoirAchatDto;

@Component
public class AvoirAchatConverter extends AbstractConverter<AvoirAchat, AvoirAchatDto> {

    @Autowired
    private AvoirAchatItemConverter avoirAchatItemConverter ;
    @Autowired
    private TaxeConverter taxeConverter ;
    @Autowired
    private FournisseurConverter fournisseurConverter ;
    @Autowired
    private DepotConverter depotConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private EtatAvoirAchatConverter etatAvoirAchatConverter ;
    @Autowired
    private EntrepriseSocieteConverter entrepriseSocieteConverter ;
    private boolean entrepriseSociete;
    private boolean fournisseur;
    private boolean etatAvoirAchat;
    private boolean avoirAchatItems;

    public  AvoirAchatConverter(AvoirAchatItem avoirAchatItemTaxe taxeFournisseur fournisseurDepot depotProduit produitEtatAvoirAchat etatAvoirAchatEntrepriseSociete entrepriseSociete){
        super(AvoirAchat.class, AvoirAchatDto.class);
        init(true);
        this.avoirAchatItem =  avoirAchatItem
        this.taxe =  taxe
        this.fournisseur =  fournisseur
        this.depot =  depot
        this.produit =  produit
        this.etatAvoirAchat =  etatAvoirAchat
        this.entrepriseSociete =  entrepriseSociete
    }

    @Override
    public AvoirAchat toItem(AvoirAchatDto dto) {
        if (dto == null) {
            return null;
        } else {
        AvoirAchat item = new AvoirAchat();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getBarCode()))
                item.setBarCode(dto.getBarCode());
            if(StringUtil.isNotEmpty(dto.getCodeAvoirAchat()))
                item.setCodeAvoirAchat(dto.getCodeAvoirAchat());
            if(StringUtil.isNotEmpty(dto.getNumeroFactureAvoirFournisseur()))
                item.setNumeroFactureAvoirFournisseur(dto.getNumeroFactureAvoirFournisseur());
            if(StringUtil.isNotEmpty(dto.getDateFactureAvoirFournisseur()))
                item.setDateFactureAvoirFournisseur(DateUtil.stringEnToDate(dto.getDateFactureAvoirFournisseur()));
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

            if(this.etatAvoirAchat && dto.getEtatAvoirAchat()!=null &&  dto.getEtatAvoirAchat().getId() != null)
                item.setEtatAvoirAchat(etatAvoirAchatConverter.toItem(dto.getEtatAvoirAchat())) ;


            if(this.avoirAchatItems && ListUtil.isNotEmpty(dto.getAvoirAchatItems()))
                item.setAvoirAchatItems(avoirAchatItemConverter.toItem(dto.getAvoirAchatItems()));


        return item;
        }
    }

    @Override
    public AvoirAchatDto toDto(AvoirAchat item) {
        if (item == null) {
            return null;
        } else {
            AvoirAchatDto dto = new AvoirAchatDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getBarCode()))
                dto.setBarCode(item.getBarCode());
            if(StringUtil.isNotEmpty(item.getCodeAvoirAchat()))
                dto.setCodeAvoirAchat(item.getCodeAvoirAchat());
            if(StringUtil.isNotEmpty(item.getNumeroFactureAvoirFournisseur()))
                dto.setNumeroFactureAvoirFournisseur(item.getNumeroFactureAvoirFournisseur());
            if(item.getDateFactureAvoirFournisseur()!=null)
                dto.setDateFactureAvoirFournisseur(DateUtil.dateTimeToString(item.getDateFactureAvoirFournisseur()));
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
        if(this.etatAvoirAchat && item.getEtatAvoirAchat()!=null) {
            dto.setEtatAvoirAchat(etatAvoirAchatConverter.toDto(item.getEtatAvoirAchat())) ;
        }
        if(this.avoirAchatItems && ListUtil.isNotEmpty(item.getAvoirAchatItems())){
            avoirAchatItemConverter.init(true);
            avoirAchatItemConverter.setAvoirAchat(false);
            dto.setAvoirAchatItems(avoirAchatItemConverter.toDto(item.getAvoirAchatItems()));
            avoirAchatItemConverter.setAvoirAchat(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.avoirAchatItems = value;
    }

    public void initObject(boolean value) {
        this.entrepriseSociete = value;
        this.fournisseur = value;
        this.etatAvoirAchat = value;
    }


    public AvoirAchatItemConverter getAvoirAchatItemConverter(){
        return this.avoirAchatItemConverter;
    }
    public void setAvoirAchatItemConverter(AvoirAchatItemConverter avoirAchatItemConverter ){
        this.avoirAchatItemConverter = avoirAchatItemConverter;
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
    public EtatAvoirAchatConverter getEtatAvoirAchatConverter(){
        return this.etatAvoirAchatConverter;
    }
    public void setEtatAvoirAchatConverter(EtatAvoirAchatConverter etatAvoirAchatConverter ){
        this.etatAvoirAchatConverter = etatAvoirAchatConverter;
    }
    public EntrepriseSocieteConverter getEntrepriseSocieteConverter(){
        return this.entrepriseSocieteConverter;
    }
    public void setEntrepriseSocieteConverter(EntrepriseSocieteConverter entrepriseSocieteConverter ){
        this.entrepriseSocieteConverter = entrepriseSocieteConverter;
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
    public boolean  isEtatAvoirAchat(){
        return this.etatAvoirAchat;
    }
    public void  setEtatAvoirAchat(boolean etatAvoirAchat){
        this.etatAvoirAchat = etatAvoirAchat;
    }
    public boolean  isAvoirAchatItems(){
        return this.avoirAchatItems ;
    }
    public void  setAvoirAchatItems(boolean avoirAchatItems ){
        this.avoirAchatItems  = avoirAchatItems ;
    }
}
