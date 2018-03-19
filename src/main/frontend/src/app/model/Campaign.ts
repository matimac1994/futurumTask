import {Town} from "./Town";
import {KeyWord} from "./KeyWord";

export class Campaign{
  public id: number;
  public name: string;
  public minAmount: number;
  public status: boolean = false;
  public radius: number;
  public fund: number;
  public town: Town;
  public keyWords: KeyWord[];
}
