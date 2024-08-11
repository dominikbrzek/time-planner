import { v4 as uuid } from "uuid";
import {Subtask} from "./subtask";

export class Task {
  id: string = uuid();
  title: string = "";
  description: string = "";
  estimation: string = "";
  priority: string = "";
  deadline: Date = new Date();
  subtasks: Subtask[] = [];
  isEditing?: boolean;
}
