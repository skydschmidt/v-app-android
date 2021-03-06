package app.v.verbundstudium.com.verbundstudiumapp.di

import app.v.verbundstudium.com.verbundstudiumapp.MainActivity
import app.v.verbundstudium.com.verbundstudiumapp.calendar.CalendarActivity
import app.v.verbundstudium.com.verbundstudiumapp.exams.ExamsActivity
import app.v.verbundstudium.com.verbundstudiumapp.lessons.LessonsActivity
import app.v.verbundstudium.com.verbundstudiumapp.login.LoginActivity
import app.v.verbundstudium.com.verbundstudiumapp.mensa.MensaFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [InteractorModule::class, RepositoryModule::class, ServiceModule::class])
interface MainComponent {

    fun inject(activity: LoginActivity)
    fun inject(activity: MainActivity)
    fun inject(activity: LessonsActivity)
    fun inject(activity: ExamsActivity)
    fun inject(activity: CalendarActivity)
    fun inject(fragment: MensaFragment)

}