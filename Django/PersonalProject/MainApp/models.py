from django.db import models

# Create your models here.
class User(models.Model):
    name = models.CharField(max_length=40)
    email = models.EmailField()
    number = models.IntegerField()
    dni = models.CharField(max_length=9)

    def __str__(self):
        return self.name

class Platform(models.Model):
    nomPlataforma = models.CharField(max_length=50)
    data = models.DateField()
    usersSuscribed = models.ManyToManyField(User)

    def __str__(self):
        return self.nomPlataforma

class Videogames(models.Model):
    NameVideogame = models.CharField(max_length=50)
    Price = models.IntegerField()
    isNew = models.BooleanField()
    playersPlayed = models.ManyToManyField(User)
    platformProvider = models.ForeignKey(Platform, on_delete=models.CASCADE, related_name="videogames")
    
    def __str__(self):
        return self.NameVideogame
