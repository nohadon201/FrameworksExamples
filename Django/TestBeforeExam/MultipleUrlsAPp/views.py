from django.shortcuts import render
from django.views.generic.base import View
from django.http import HttpRequest, HttpResponse

# Create your views here.
class MultipleURL(View):
    # Definim el mètode HTTP el qual s'ha d'atendre
    def get(self,request ):
        return HttpResponse(content='Exemple de multiples urls agrupades')

