<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('superzings', function (Blueprint $table) {
            $table->id('idSuperzing');
            $table->foreignId('idUser')->nullable()->constrained('users')->references('idUser');
            $table->string('Nom');
            $table->boolean('Empresonat');
            $table->boolean('Perillos');
            $table->integer('numDiesPreso');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('superzings');
    }
};
