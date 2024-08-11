import { Component } from '@angular/core';

@Component({
  selector: 'app-pomodoro',
  standalone: true,
  imports: [],
  templateUrl: './pomodoro.component.html',
  styleUrl: './pomodoro.component.scss'
})
export class PomodoroComponent {

  breakLength: number = 5;
  sessionLength: number = 25;
  sessionType: string = "Praca"
  timeLeft: number = this.sessionLength



  // cykle pomodoro
  // ilość cykli podana na dole
  // długość przerwy w minutach
  // długość pracy w minutach
  // guzik i formularz do zmiany konfiguracji



}
