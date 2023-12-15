import { TasaInteres } from "./tasa-interes";

export class TipoCuenta {
  codTipoCuenta: string;
  codTasaInteres: TasaInteres;
  nombre: string;
  descripcion: string;
  tipoCapitalizacion: string;
  formaCapitalizacion: string;
  maximoNumeroIntervinientes: number;
  fechaCreacion: Date;

}

