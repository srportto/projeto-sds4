import { Seller } from "./seller"

export type Sale = {
  id: number;
  visited: number;
  deals: number;
  amount: number;     // mesmo tendo ponto flutuante (ex: double do java) aqui eh apenas "number"
  date: string;       // mesmo sendo uma data (ex: 2021-09-18) aqui eh apenas "string"
  seller: Seller;
}

export type SalePage = {
  content?: Sale[];
  last: boolean;
  totalElements: number;
  totalPages: number;
  first: boolean;
  number: number;
  numberOfElements?: number;
  size?: number;
  empty?: boolean;
}

export type SaleSum = {
  sellername: string;
  sum: number;
}

export type SaleSuccess = {
  sellername: string;
  visited: number;
  deals: number;
}