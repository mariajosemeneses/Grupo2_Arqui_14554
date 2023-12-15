import { TasaInteres } from "../Cuenta/tasa-interes";

export class TipoCredito {
  codTipoCredito: number;
  codTasaInteres: TasaInteres;
  nombre: string;
  descripcion: string;
  tipoCliente: string;
  unidadPlazo: string;
  plazoMinimo: number;
  plazoMaximo: number;
  montoMinimo: number;
  montoMaximo: number;
  estado: string;
  fechaCreacion: Date;
  fechaUltimoCambio: Date;
}
