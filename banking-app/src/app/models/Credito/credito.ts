import { Cliente } from "../Cliente/cliente";
import { TipoCredito } from "./tipo-credito";

export class Credito {
  codCredito: number;
  codTipoCredito: TipoCredito;
  codCliente: Cliente;
  numeroOperacion: string;
  fechaCreacion: Date;
  monto: number;
  plazo: number;
  tasaInteres: number;
  estado: string;
  fechaDesembolso: Date;
  fechaUltimoPago: Date;
  capitalPendiente: number;
  fechaUltimoCambio: Date;
}

