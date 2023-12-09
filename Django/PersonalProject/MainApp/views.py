from django.shortcuts import render
from django.http import HttpRequest, HttpResponse, Http404,request  
from django.views.generic.base import View
from .models import Platform


# Create your views here.
class AddPlatform(View):
        def get(self,request):
            return render(request, 'addplatforms.html')
        def post(self, request):
              platform = Platform()
              print(request.POST.get('nomPlatform'))
              platform.nomPlataforma = request.POST.get('nomPlatform')
              platform.data = request.POST.get('data')
              platform.save()
              return HttpResponse(content='Successfull')