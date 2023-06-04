import { Patient } from "./patient";
import { Doctor } from "./doctor";

export class Priem {
    id!:number;
    doctor!:Doctor;
    patient!:Patient;
    date!:Date;
}

