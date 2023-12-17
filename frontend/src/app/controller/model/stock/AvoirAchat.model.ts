import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {AvoirAchatItemDto} from './AvoirAchatItem.model';
import {FournisseurDto} from '../commun/Fournisseur.model';
import {EtatAvoirAchatDto} from '../commun/EtatAvoirAchat.model';
import {EntrepriseSocieteDto} from '../commun/EntrepriseSociete.model';

export class AvoirAchatDto extends BaseDto{

    public barCode: string;

    public codeAvoirAchat: string;

    public numeroFactureAvoirFournisseur: string;

   public dateFactureAvoirFournisseur: Date;

    public montantHt: null | number;

    public montantTva: null | number;

    public montantTtc: null | number;

    public description: string;

    public entrepriseSociete: EntrepriseSocieteDto ;
    public fournisseur: FournisseurDto ;
    public etatAvoirAchat: EtatAvoirAchatDto ;
     public avoirAchatItems: Array<AvoirAchatItemDto>;
    

    constructor() {
        super();

        this.barCode = '';
        this.codeAvoirAchat = '';
        this.numeroFactureAvoirFournisseur = '';
        this.dateFactureAvoirFournisseur = null;
        this.montantHt = null;
        this.montantTva = null;
        this.montantTtc = null;
        this.description = '';
        this.entrepriseSociete = new EntrepriseSocieteDto() ;
        this.fournisseur = new FournisseurDto() ;
        this.etatAvoirAchat = new EtatAvoirAchatDto() ;
        this.avoirAchatItems = new Array<AvoirAchatItemDto>();

        }

}
