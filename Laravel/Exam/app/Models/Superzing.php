<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Foundation\Auth\User as Authenticatable;
use Illuminate\Notifications\Notifiable;
use Laravel\Sanctum\HasApiTokens;

class Superzing extends Model
{
    use HasApiTokens, HasFactory, Notifiable;

    /**
     * The attributes that are mass assignable.
     *
     * @var array<int, string>
     */
    protected $primaryKey = 'idSuperzing';
    protected $fillable = [
        'Nom',
        'Empresonat',
        'Perillos',
        'numDiesPreso'
    ];
    public function user(){
        return $this->BelongsTo(User::class, 'idUser', 'idUser');
    }

}
