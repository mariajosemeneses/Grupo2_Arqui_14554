import { Credito } from "./credito";

export class CreditoTablaPagos {
  codCredito: Credito;
  codCuota: number;
  capital: number;
  interes: number;
  montoCuota: number;
  capitalRestante: number;
  fechaPlanificadaPago: Date;
  estado: string;
  fechaPagoEfectivo: Date;
  transaccionPago: string;
}
