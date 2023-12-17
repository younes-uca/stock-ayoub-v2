import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {VenteDto} from './Vente.model';
import {TaxeDto} from './Taxe.model';
import {DepotDto} from '../commun/Depot.model';
import {ProduitDto} from './Produit.model';

export class VenteItemDto extends BaseDto{

    public barCode: string;

    public quantite: null | number;

    public quantiteAvoir: null | number;

    public quantiteVendue: null | number;

    public prixUnitaireHt: null | number;

    public prixUnitaireTtc: null | number;

    public remise: null | number;

    public montantHt: null | number;

    public montantTtc: null | number;

    public depot: DepotDto ;
    public produit: ProduitDto ;
    public taxe: TaxeDto ;
    public vente: VenteDto ;
    

    constructor() {
        super();

        this.barCode = '';
        this.quantite = null;
        this.quantiteAvoir = null;
        this.quantiteVendue = null;
        this.prixUnitaireHt = null;
        this.prixUnitaireTtc = null;
        this.remise = null;
        this.montantHt = null;
        this.montantTtc = null;
        this.depot = new DepotDto() ;
        this.produit = new ProduitDto() ;
        this.taxe = new TaxeDto() ;
        this.vente = new VenteDto() ;

        }

}
