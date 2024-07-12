import {RouterModule, Routes} from '@angular/router';
import {TaskListComponent} from "./task-list/task-list.component";
import {PomodoroComponent} from "./pomodoro/pomodoro.component";
import {NgModule} from "@angular/core";
import {EisenhowerComponent} from "./eisenhower/eisenhower.component";

export const routes: Routes = [
  {path: "tasks", component: TaskListComponent},
  {path: "pomodoro", component: PomodoroComponent},
  {path: "eisenhower", component: EisenhowerComponent},
  {path: "", redirectTo: "tasks", pathMatch: "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutes {
}
