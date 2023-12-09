from django.contrib import admin
from MainApp.models import Videogames,User, Platform
# Register your models here.


class VideogameAdmin(admin.ModelAdmin):
    pass


class UserAdmin(admin.ModelAdmin):
    pass


class PlatformAdmin(admin.ModelAdmin):
    pass

admin.site.register(Videogames,admin.ModelAdmin)
admin.site.register(User,admin.ModelAdmin)
admin.site.register(Platform,admin.ModelAdmin)
