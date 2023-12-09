from django.http import HttpRequest, HttpResponse, Http404
from django.shortcuts import render
from django.views.generic.base import View
from models import Publication
# Create your views here.
class App1Test(View):
    # Definim el mètode HTTP el qual s'ha d'atendre
    def get(self,data ):
        return HttpResponse(content='Això és una prova')
class GetAllPublications(View):
    def get(self,request):
        try:
            publications = Publication.objects.all()
            Publication.objects.delete()
        except Publication.DoesNotExist:
            raise Http404("Aquest nom no existeix");
