import { Cuenta } from "./cuenta";

export class Transaccion {
  codTransaccion: number;
  codCuenta: Cuenta;
  codUnico: string;
  tipoAfectacion: string;
  valorDebe: number;
  valorHaber: number;
  tipoTransaccion: string;
  detalle: string;
  fechaCreacion: Date;
  estado: string;
  fechaAfectacion: Date;
}
