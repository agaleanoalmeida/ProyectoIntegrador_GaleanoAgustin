export class Experiencia {
    id?: number;
    nombreE: string;
    descripcionE: string;
    anioE: string;

    constructor(nombreE: string, descripcionE: string, anioE: string){

        this.descripcionE = descripcionE;
        this.nombreE    = nombreE;
        this.anioE = anioE;
    }
}
